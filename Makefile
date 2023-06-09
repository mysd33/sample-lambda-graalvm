.PHONY: clean
.PHONY: build
.PHONY: validate
.PHONY: deploy
.PHONY: deploy_guided
.PHONY: delete

.DEFAULT_GOAL := build

AP_NAME:=todo-app
BUILD_TASKS:= build-GetUsersFunction build-PostUsersFunction build-GetTodoFunction build-PostTodoFunction


clean:
	mvn clean

$(BUILD_TASKS):
	mvn -Pnative clean native:compile
	echo '#!/bin/sh' > ./target/bootstrap
	echo 'set -euo pipefail' >> ./target/bootstrap
	echo './${AP_NAME}' >> ./target/bootstrap
	ls ./target
	cp ./target/${AP_NAME} $(ARTIFACTS_DIR)	
	chmod 755 ./target/bootstrap
	cp ./target/bootstrap $(ARTIFACTS_DIR)	

build:
	sam build

validate:
	sam validate

unit_test:
	mvn test	

deploy_guided:
	sam deploy --guided

deploy:
	sam deploy

delete:
	sam delete

