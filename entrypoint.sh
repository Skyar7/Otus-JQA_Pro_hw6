#!/usr/bin/env bash

command="mvn test -Ddevice.name=$DEVICE_NAME -Dplatform.name=$PLATFORM_NAME -Dplatform.version=$PLATFORM_VERSION -Dremote.url=$REMOTE_URL"

echo "Run: " $command
eval $command
echo "End of running: " $command
