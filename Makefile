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
	mvn clean package

validate:
	sam validate

unit_test:
	mvn test	

deploy_guided:
	sam deploy -t template.yaml --guided

deploy:
	sam deploy -t template.yaml

delete:
	sam delete

