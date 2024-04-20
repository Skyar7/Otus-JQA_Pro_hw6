timeout(60) {
    node("maven") {
        wrap([$class: 'BuildUser']) {
            currentBuild.description = """
build user: ${BUILD_USER}
branch: ${REFSPEC}
"""

            config = readYaml text: env.YAML_CONFIG ?: null;

            if (config != null) {
                for (param in config.entrySet()) {
                    env."${param.getKey()}" = param.getValue()
                }
            }
        }

        stage("Checkout") {
            checkout scm;
        }
        stage("Create configuration") {
            sh "echo DEVICE_NAME=${env.getProperty('DEVICE_NAME')} > ./.env"
            sh "echo PLATFORM_NAME=${env.getProperty('PLATFORM_NAME')} >> ./.env"
            sh "echo PLATFORM_VERSION=${env.getProperty('PLATFORM_VERSION')} >> ./.env"
            sh "echo REMOTE_URL=${env.getProperty('REMOTE_URL')} >> ./.env"
        }
        stage("Run mobile tests") {
            sh "mkdir ./reports"
            sh "docker run --rm --env-file -v ./reports:root/mobile_tests_allure-results ./.env -t mobile_tests:${env.getProperty('TEST_VERSION')}"
        }
        stage("Publish allure results") {
            REPORT_DISABLE = Boolean.parseBoolean(env.getProperty('REPORT_DISABLE')) ?: false
            allure([
                    reportBuildPolicy: 'ALWAYS',
                    results: ["./reports", "./allure-results"],
                    disabled: REPORT_DISABLE
            ])
        }
    }
}