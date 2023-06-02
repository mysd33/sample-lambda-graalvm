.PHONY: clean
.PHONY: build
.PHONY: validate
.PHONY: deploy
.PHONY: deploy_guided
.PHONY: delete

.DEFAULT_GOAL := build

clean:
	mvn clean

build:
	mvn -Pnative clean native:compile
	cp ./target/native $(ARTIFACTS_DIR)
	chmod 755 ./target/classes/bootstrap
	cp ./target/classes/bootstrap $(ARTIFACTS_DIR)	

sam_build:
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

