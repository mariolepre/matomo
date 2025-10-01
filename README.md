# E2E Web Testing benchmark
## Gherkin specifications for Matomo
[Matomo](https://matomo.org/) is an open-source web analytics platform written in PHP. Originally known as Piwik, it is now used by thousands of organizations to analyze website traffic while respecting user privacy.

This directory contains Gherkin specifications and an automated installer for Matomo 5.4.0
## Deployment instructions
The Docker container for Matomo can be created using the docker-compose.yml file contained in this directory. Just move into the directory using a terminal and type:
```bash
docker compose up -d --build
```

The web application will be exposed on [http://localhost:8082](http://localhost:8082)

An installation wizard must be followed after deploying the container.

## Installation instructions
The installation wizard can be executed automatically by running InstallerTest.install (located in the Maven project matomo-installer-5.4.0) as a JUnit test. You can run it with Maven using the command
```bash
mvn test -Dtest=InstallerTest#install
```

in the directory ```matomo-installer-5.4.0```.

If for any reason, the automatic installation fails, these are the parameters that you should set in the installation wizard:

* Database Server: db
* Login: root
* Password: root
* Database Name: matomo

Superuser and Website can be chosen independently.

Now you are ready to use Matomo!
