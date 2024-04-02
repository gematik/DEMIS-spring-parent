<img align="right" width="250" height="47" src="../media/Gematik_Logo_Flag.png"/> <br/>

# Spring Parent

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#getting-started">Getting Started</a></li>
    <li><a href="#security-policy">Security Policy</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

## About The Project

This project serves as a parent POM for other demis spring boot based projects. It provides common dependency management
and build plugin configurations for child projects. The main purpose of this repository is to centralize and standardize
project settings, making it easier to manage dependencies and plugins across multiple projects.

### Quality Gate

[![Quality Gate Status](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Aspring-parent&metric=alert_status&token=sqb_16f12d45f6d527f1744e9a9be26525fd62709a62)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Aspring-parent)
[![Vulnerabilities](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Aspring-parent&metric=vulnerabilities&token=sqb_16f12d45f6d527f1744e9a9be26525fd62709a62)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Aspring-parent)
[![Bugs](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Aspring-parent&metric=bugs&token=sqb_16f12d45f6d527f1744e9a9be26525fd62709a62)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Aspring-parent)
[![Code Smells](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Aspring-parent&metric=code_smells&token=sqb_16f12d45f6d527f1744e9a9be26525fd62709a62)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Aspring-parent)
[![Lines of Code](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Aspring-parent&metric=ncloc&token=sqb_16f12d45f6d527f1744e9a9be26525fd62709a62)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Aspring-parent)

### Release Notes

See [ReleaseNotes](../ReleaseNotes.md) for all information regarding the (newest) releases.


## Getting Started

To use this parent POM in your Java projects, follow these steps:

In your child project's pom.xml, add the following lines to specify the parent POM:

    <parent>
        <groupId>de.gematik.demise</groupId>
        <artifactId>spring-parent</artifactId>
        <version>x.y.z</version>
    </parent>

Include the necessary dependencies and plugins in your child project's pom.xml. The parent POM defines common
dependencies and build plugins that can be inherited by child projects.

Some dependencies are optional and encapsulated in profiles. To get these dependencies, you must activate the profile with an empty file (named like the profile) in the directory ".mvn-profiles" in your project. This approach has the advantage that the child project becomes no unnecessary dependencies.

Available profiles:
<ol>
<li>dependencies-webservice</li>
<li>dependencies-feign</li>
</ol>

If you want to use the service-base library you have to add the following dependency

            <dependency>
                <groupId>de.gematik.demis</groupId>
                <artifactId>service-base</artifactId>
            </dependency>


Customize your child project's configurations as needed. You can override settings from the parent POM in your child
project's pom.xml.

Build and manage your child projects with the configured settings from this parent POM.

## Security Policy

If you want to see the security policy, please check our [SECURITY.md](SECURITY.md).

## Contributing

If you want to contribute, please check our [CONTRIBUTING.md](CONTRIBUTING.md).

## License

EUROPEAN UNION PUBLIC LICENCE v. 1.2

EUPL © the European Union 2007, 2016

Copyright (c) 2023 gematik GmbH

See [LICENSE](../LICENSE.md).

## Contact

E-Mail to [DEMIS Entwicklung](mailto:demis-entwicklung@gematik.de?subject=[GitHub]%20Validation-Service)