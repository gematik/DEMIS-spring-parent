<img align="right" width="250" height="47" src="media/Gematik_Logo_Flag.png"/> <br/>

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

See [ReleaseNotes](ReleaseNotes.md) for all information regarding the (newest) releases.


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
<li>docker</li>
<li>dependencies-webservice</li>
<li>dependencies-feign</li>
<li>generate-openapi-docs</li>
<li>generate-test-jar</li>
<li>external</li>
</ol>

If you want to use the service-base library you have to add the following dependency

      <dependency>
          <groupId>de.gematik.demis</groupId>
          <artifactId>service-base</artifactId>
      </dependency>


Customize your child project's configurations as needed. You can override settings from the parent POM in your child
project's pom.xml.

Build and manage your child projects with the configured settings from this parent POM.

## Installation

To install the project to your local maven repository use

```sh
mvn clean install -P generate-test-jar
```

this will generate the test-jar that is used by at least Notification-Processing-Service. Hence you are able to test changes to the spring parent locally by updating the dependency one services based on this project. 

## Security Policy

If you want to see the security policy, please check our [SECURITY.md](.github/SECURITY.md).

## Contributing

If you want to contribute, please check our [CONTRIBUTING.md](.github/CONTRIBUTING.md).

## License
Copyright 2023-2025 gematik GmbH

EUROPEAN UNION PUBLIC LICENCE v. 1.2

EUPL © the European Union 2007, 2016

See the [LICENSE](./LICENSE.md) for the specific language governing permissions and limitations under the License

## Additional Notes and Disclaimer from gematik GmbH

1. Copyright notice: Each published work result is accompanied by an explicit statement of the license conditions for use. These are regularly typical conditions in connection with open source or free software. Programs described/provided/linked here are free software, unless otherwise stated.
2. Permission notice: Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions::
   1. The copyright notice (Item 1) and the permission notice (Item 2) shall be included in all copies or substantial portions of the Software.
   2. The software is provided "as is" without warranty of any kind, either express or implied, including, but not limited to, the warranties of fitness for a particular purpose, merchantability, and/or non-infringement. The authors or copyright holders shall not be liable in any manner whatsoever for any damages or other claims arising from, out of or in connection with the software or the use or other dealings with the software, whether in an action of contract, tort, or otherwise.
   3. The software is the result of research and development activities, therefore not necessarily quality assured and without the character of a liable product. For this reason, gematik does not provide any support or other user assistance (unless otherwise stated in individual cases and without justification of a legal obligation). Furthermore, there is no claim to further development and adaptation of the results to a more current state of the art.
3. Gematik may remove published results temporarily or permanently from the place of publication at any time without prior notice or justification.
4. Please note: Parts of this code may have been generated using AI-supported technology.’ Please take this into account, especially when troubleshooting, for security analyses and possible adjustments.

See [LICENSE](LICENSE.md).

## Contact

E-Mail to [DEMIS Entwicklung](mailto:demis-entwicklung@gematik.de?subject=[GitHub]%20spring-parent)