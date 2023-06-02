.PHONY: clean
.PHONY: build
.PHONY: validate
.PHONY: deploy
.PHONY: deploy_guided
.PHONY: delete

.DEFAULT_GOAL := build

clean:
	mvn clean

build-GetUsersFunction:
	mvn -Pnative clean native:compile
	cp ./target/native $(ARTIFACTS_DIR)
	chmod 755 ./target/classes/bootstrap
	cp ./target/classes/bootstrap $(ARTIFACTS_DIR)	

build-PostUsersFunction:
	mvn -Pnative clean native:compile
	cp ./target/native $(ARTIFACTS_DIR)
	chmod 755 ./target/classes/bootstrap
	cp ./target/classes/bootstrap $(ARTIFACTS_DIR)	

build-GetTodoFunction:
	mvn -Pnative clean native:compile
	cp ./target/native $(ARTIFACTS_DIR)
	chmod 755 ./target/classes/bootstrap
	cp ./target/classes/bootstrap $(ARTIFACTS_DIR)	

build-PostTodoFunction:
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

