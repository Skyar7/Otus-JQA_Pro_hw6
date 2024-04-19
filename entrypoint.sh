#!/bin/bash

mvn test -Ddevice.name=$DEVICE_NAME -Dplatform.name=$PLATFORM_NAME -Dplatform.version=$PLATFORM_VERSION -Dremote.url=$REMOTE_URL
