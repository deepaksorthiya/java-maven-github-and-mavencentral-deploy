[![Maven Publish Sonatype Central And Github](https://github.com/deepaksorthiya/java-maven-github-and-mavencentral-deploy/actions/workflows/publish-maven-artifact.yml/badge.svg)](https://github.com/deepaksorthiya/java-maven-github-and-mavencentral-deploy/actions/workflows/publish-maven-artifact.yml)

---

### ** Java maven project artifact deployment to GitHub packages and Maven Central **

---

# Getting Started

### Requirements:

```
Maven: 3.9+
Java: 17
```

## Setup Sonatype Account

Create an account at [Sonatype Central](https://central.sonatype.com/).

If you are signin with your existing GitHub account, the namespace for your account will be automatically validated.

## Namespace Configuration and Domain Validation

Add and validate [your namespace](https://central.sonatype.com/publishing/namespaces) corresponding to your domain and
validate the namespace `io.github.YOUR_GITHUB_NAME` by creating a test repository on GitHub. For GitHub users, namespace
validation [is automatic](https://central.sonatype.org/register/central-portal/#for-code-hosting-services-with-personal-groupid)
upon account creation.

## GPG Key Generation and Upload to Server

Follow this Tutorial as
reference [GPG Key Generation](https://docs.github.com/en/authentication/managing-commit-signature-verification/generating-a-new-gpg-key)

Following the [Sonatype GPG requirements](https://central.sonatype.org/publish/requirements/gpg/):

-
    1. If you are on version 2.1.17 or greater, paste the text below to generate a GPG key pair.

```
gpg --full-generate-key
```

If you are not on version 2.1.17 or greater, the ```gpg --full-generate-key``` command doesn't work. Paste the text
below and

```
gpg --default-new-key-algo rsa4096 --gen-key
```

-
    2. Extract the key YOUR_GPG_KEY_ID (`gpg --list-secret-keys --keyid-format=long`)

```
gpg --list-secret-keys --keyid-format=long
/home/deepak/.gnupg/pubring.kbx
-------------------------------
sec   rsa4096/83DF97BEEABA857F 2025-01-17 [SC]
      43B1F7FB6CACCCBEE91955F383DF97BEEABA857F
uid                 ************
ssb   ************
```

Note, here your GPG KEY ID is ```83DF97BEEABA857F```

-
    3. Distribute it (`gpg --keyserver keyserver.ubuntu.com --send-keys YOUR_GPG_KEY_ID`)
-
    4. Export the private key (`gpg --armor --export-secret-key <key-id> > privkey.asc`)

## Maven POM file Configuration

Configure your `pom.xml` with necessary plugins for publishing to Sonatype. See the
project's [pom.xml](pom.xml) for an example
configuration.

Required plugins:

- central-publishing-maven-plugin
- maven-source-plugin
- maven-javadoc-plugin
- maven-gpg-plugin

## GitHub Secrets and Variables Setup for Automation

Visit "Actions secrets and variables" page in Github UI (`your_repo/settings/secrets/actions`).

Under ``Secrets`` tab Add secrets to your GitHub repository for automated publishing:

- `MAVEN_USERNAME` and `MAVEN_CENTRAL_TOKEN`:
  Generated [from your Sonatype account](https://central.sonatype.com/account)
  User Token.
- `MAVEN_GPG_PRIVATE_KEY`: The content of `privkey.asc`.
- `MAVEN_GPG_PASSPHRASE`: Your GPG key passphrase.

Under ``Variables`` tab add this

- `MAVEN_USERNAME` and `MAVEN_CENTRAL_TOKEN`:
  Generated [from your Sonatype account](https://central.sonatype.com/account)
  User Token.
- `MAVEN_GPG_PASSPHRASE`: Your GPG key passphrase.

# Local Deployment

Setup your local ``settings.xml`` with

```
<servers>
    <server>
        <id>central</id>
        <username></username>
        <password></password>
    </server>
</servers>
```

## Deploy application using:

```bash
mvn clean deploy -Pcentral
```

A minimalistic Maven project to demonstrate the required setup for publishing to the
[Central Repository via OSSRH](http://central.sonatype.org/) managed by [Sonatype](http://www.sonatype.com/).

Creation of this project and further usage tips are available in the
[free
video series 'Easy Publishing to the Central Repository'](http://central.sonatype.org/articles/2016/Feb/02/free-video-series-easy-publishing-to-the-central-repository/).

See it all in action in [this video](https://www.youtube.com/watch?time_continue=2&v=N8_2-hpTnFA).

### Reference Documentation

For further reference, please consider the following sections:

* [GPG Guide](https://central.sonatype.org/publish/requirements/gpg/)
* [Sonatype Central Login](https://central.sonatype.com/)
* [Apache Maven2 Central Repos](https://repo1.maven.org/maven2/)
* [Sonatype Apache Maven Consumer Guide](https://central.sonatype.org/consume/consume-apache-maven/)
* [Sonatype Apache Maven Publish Guide](https://central.sonatype.org/register/central-portal/)
* [Sonatype OSS Snapshot Maven Repos](https://s01.oss.sonatype.org/content/repositories/snapshots)
* [Sonatype OSS Stagging Maven Repos](https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/)