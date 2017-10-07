version=$(shell egrep -o "[0-9]+\.[0-9]+\.[0-9]+(-SNAPSHOT)?" project.clj  | head -1)

all:
	$(error please pick a target)

.PHONY: test
test:
	lein test

.PHONY: release
release:
	git tag -f $(version)
	lein deploy clojars
	git push && git push --tags
