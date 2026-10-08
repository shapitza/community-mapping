package com.communitymap;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Executable version of the Boundary-Control-Entity rules in docs/architecture.md.
 *
 * <pre>
 * com.communitymap.&lt;component&gt;.boundary   HTTP endpoints and request/response records
 * com.communitymap.&lt;component&gt;.control    business logic and repositories
 * com.communitymap.&lt;component&gt;.entity     domain objects
 * </pre>
 */
class ArchitectureTest {

    private static final String ROOT = "com.communitymap";

    private static JavaClasses classes;

    @BeforeAll
    static void importClasses() {
        classes = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages(ROOT);
    }

    @Test
    void entitiesDependOnNothingAboveThem() {
        noClasses().that().resideInAPackage("..entity..")
                .should().dependOnClassesThat().resideInAnyPackage("..control..", "..boundary..")
                .because("entities are the bottom layer of every component")
                .check(classes);
    }

    @Test
    void controlDoesNotDependOnBoundary() {
        noClasses().that().resideInAPackage("..control..")
                .should().dependOnClassesThat().resideInAPackage("..boundary..")
                .because("boundary calls control, never the other way round")
                .check(classes);
    }

    @Test
    void boundaryIsOnlyUsedInsideItsOwnComponent() {
        for (String component : components()) {
            noClasses().that().resideOutsideOfPackage(ROOT + "." + component + "..")
                    .should().dependOnClassesThat().resideInAPackage(ROOT + "." + component + ".boundary..")
                    .because("other components talk to '" + component + "' through its control package")
                    .check(classes);
        }
    }

    @Test
    void componentsHaveNoCycles() {
        slices().matching(ROOT + ".(*)..")
                .should().beFreeOfCycles()
                .check(classes);
    }

    private static Set<String> components() {
        Set<String> components = new TreeSet<>();
        for (JavaClass javaClass : classes) {
            String pkg = javaClass.getPackageName();
            if (pkg.startsWith(ROOT + ".")) {
                components.add(pkg.substring(ROOT.length() + 1).split("\\.")[0]);
            }
        }
        return components;
    }
}
