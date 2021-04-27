import kotlin.experimental.ExperimentalTypeInference

import org.gradle.api.artifacts.Dependency as ArtifactDependency

sealed class Dependency @OptIn(ExperimentalTypeInference::class) constructor(
    configuration: String,
    getGroup: String?,
    getName: String,
    getVersion: String?,
    getReason: String?
): ArtifactDependency by object: ArtifactDependency {
    override fun getGroup(): String? = getGroup
    override fun getName(): String = getName
    override fun getVersion(): String? = getVersion
    override fun getReason(): String? = getReason
    override fun because(reason: String?) {}
    override fun contentEquals(p0: ArtifactDependency): Boolean = equals(p0)
    override fun copy(): ArtifactDependency =
        from(configuration, getGroup, getName, getVersion, getReason)
} {

    abstract val getGroup: String?
    abstract val getName: String
    abstract val getVersion: String?
    abstract val getReason: String?

    data class Implementation(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("implementation", getGroup, getName, getVersion, getReason)

    data class ImplementationDependenciesMetadata(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("implementationDependenciesMetadata", getGroup, getName, getVersion, getReason)

    data class Api(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("api", getGroup, getName, getVersion, getReason)

    data class ApiElements(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("apiElements", getGroup, getName, getVersion, getReason)

    data class Default(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("default", getGroup, getName, getVersion, getReason)

    data class Runtime(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("runtime", getGroup, getName, getVersion, getReason)

    data class RuntimeOnly(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("runtimeOnly", getGroup, getName, getVersion, getReason)

    data class RuntimeClasspath(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("runtimeClasspath", getGroup, getName, getVersion, getReason)

    data class Compile(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("compile", getGroup, getName, getVersion, getReason)

    data class CompileClasspath(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("compileClasspath", getGroup, getName, getVersion, getReason)

    data class CompileOnly(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("compileOnly", getGroup, getName, getVersion, getReason)

    data class KotlinCompilerClasspath(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("kotlinCompilerClasspath", getGroup, getName, getVersion, getReason)

    data class KotlinCompilerPluginClasspath(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("kotlinCompilerClasspath", getGroup, getName, getVersion, getReason)

    data class KotlinScriptDef(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("kotlinScriptDef", getGroup, getName, getVersion, getReason)

    data class KotlinScriptDefExtensions(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("kotlinScriptDefExtensions", getGroup, getName, getVersion, getReason)

    data class TestApi(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testApi", getGroup, getName, getVersion, getReason)

    data class TestApiDependenciesMetadata(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testApiDependenciesMetadata", getGroup, getName, getVersion, getReason)

    data class TestCompile(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testCompile", getGroup, getName, getVersion, getReason)

    data class TestCompileClasspath(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testCompileClasspath", getGroup, getName, getVersion, getReason)

    data class TestCompileOnly(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testCompileOnly", getGroup, getName, getVersion, getReason)

    data class TestImplementation(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testImplementation", getGroup, getName, getVersion, getReason)

    data class TestImplementationDependenciesMetadata(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testImplementationDependenciesMetadata", getGroup, getName, getVersion, getReason)

    data class TestRuntime(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testRuntime", getGroup, getName, getVersion, getReason)

    data class TestRuntimeOnly(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testRuntimeOnly", getGroup, getName, getVersion, getReason)

    data class Kapt(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("kapt", getGroup, getName, getVersion, getReason)

    data class TestKapt(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testKapt", getGroup, getName, getVersion, getReason)

    data class SourceArtifacts(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("sourceArtifacts", getGroup, getName, getVersion, getReason)

    data class TestRuntimeClasspath(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testRuntimeClasspath", getGroup, getName, getVersion, getReason)

    data class RuntimeOnlyDependenciesMetadata(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("runtimeOnlyDependenciesMetadata", getGroup, getName, getVersion, getReason)

    data class TestRuntimeOnlyDependenciesMetadata(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testRuntimeOnlyDependenciesMetadata", getGroup, getName, getVersion, getReason)

    data class ApiDependenciesMetadata(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("apiDependenciesMetadata", getGroup, getName, getVersion, getReason)

    data class CompileOnlyDependenciesMetadata(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("compileOnlyDependenciesMetadata", getGroup, getName, getVersion, getReason)

    data class TestCompileOnlyDependenciesMetadata(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("compileOnlyDependenciesMetadata", getGroup, getName, getVersion, getReason)

    data class Archives(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("archives", getGroup, getName, getVersion, getReason)

    data class KotlinKlibCommonizerClasspath(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("kotlinKlibCommonizerClasspath", getGroup, getName, getVersion, getReason)

    data class KotlinNativeCompilerPluginClasspath(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("kotlinNativeCompilerPluginClasspath", getGroup, getName, getVersion, getReason)

    data class TestKotlinScriptDef(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testKotlinScriptDef", getGroup, getName, getVersion, getReason)

    data class TestKotlinScriptDefExtensions(
        override val getGroup: String?,
        override val getName: String,
        override val getVersion: String?,
        override val getReason: String?
    ): Dependency("testKotlinScriptDefExtensions", getGroup, getName, getVersion, getReason)

    companion object {
        fun from(
            configuration: String,
            getGroup: String?,
            getName: String,
            getVersion: String?,
            getReason: String?
        ): Dependency = when(configuration) {
            "implementationDependenciesMetadata"
                -> ImplementationDependenciesMetadata(getGroup, getName, getVersion, getReason)
            "api"
                -> Api(getGroup, getName, getVersion, getReason)
            "apiElements"
                -> ApiElements(getGroup, getName, getVersion, getReason)
            "default"
                -> Default(getGroup, getName, getVersion, getReason)
            "runtime"
                -> Runtime(getGroup, getName, getVersion, getReason)
            "runtimeOnly"
                -> RuntimeOnly(getGroup, getName, getVersion, getReason)
            "runtimeClasspath"
                -> RuntimeClasspath(getGroup, getName, getVersion, getReason)
            "compile"
                -> Compile(getGroup, getName, getVersion, getReason)
            "compileClasspath"
                -> CompileClasspath(getGroup, getName, getVersion, getReason)
            "compileOnly"
                -> CompileOnly(getGroup, getName, getVersion, getReason)
            "kotlinCompilerClasspath"
                -> KotlinCompilerClasspath(getGroup, getName, getVersion, getReason)
            "kotlinCompilerPluginClasspath"
                -> KotlinCompilerPluginClasspath(getGroup, getName, getVersion, getReason)
            "kotlinScriptDef"
                -> KotlinScriptDef(getGroup, getName, getVersion, getReason)
            "kotlinScriptDefExtensions"
                -> KotlinScriptDefExtensions(getGroup, getName, getVersion, getReason)
            "testApi"
                -> TestApi(getGroup, getName, getVersion, getReason)
            "testApiDependenciesMetadata"
                -> TestApiDependenciesMetadata(getGroup, getName, getVersion, getReason)
            "testCompile"
                -> TestCompile(getGroup, getName, getVersion, getReason)
            "testImplementation"
                -> TestImplementation(getGroup, getName, getVersion, getReason)
            else
                -> Implementation(getGroup, getName, getVersion, getReason)
        }
    }
}
