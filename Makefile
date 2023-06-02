.PHONY: clean
.PHONY: build
.PHONY: validate
.PHONY: deploy
.PHONY: deploy_guided
.PHONY: delete

.DEFAULT_GOAL := build

BUILD_TASKS: build-GetUsersFunction build-PostUsersFunction build-GetTodoFunction build-PostTodoFunction
clean:
	mvn clean

$(BUILD_TASKS):
	mvn -Pnative clean native:compile
	cp ./target/native $(ARTIFACTS_DIR)
	chmod 755 ./target/classes/bootstrap
	cp ./target/classes/bootstrap $(ARTIFACTS_DIR)	

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

