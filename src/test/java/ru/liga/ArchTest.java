package ru.liga;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("ru.liga");

        noClasses()
            .that()
                .resideInAnyPackage("ru.liga.service..")
            .or()
                .resideInAnyPackage("ru.liga.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..ru.liga.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
