pluginManagement {
	repositories {
		mavenLocal()
		mavenCentral()
		gradlePluginPortal()
		maven("https://maven.fabricmc.net/") { name = "Fabric" }
		maven("https://maven.neoforged.net/releases/") { name = "NeoForged" }
		maven("https://maven.kikugie.dev/snapshots") { name = "KikuGie Snapshots" }
		maven("https://maven.kikugie.dev/releases") { name = "KikuGie Releases" }
		maven("https://maven.parchmentmc.org") { name = "ParchmentMC" }
	}
	includeBuild("build-logic")
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
	id("dev.kikugie.stonecutter") version "0.9.2"
}

stonecutter {
	create(rootProject) {
		fun match(version: String, vararg loaders: String) =
			loaders.forEach { version("$version-$it", version).buildscript = getBuildscript(it, version) }

		match("26.2", "neoforge")
		match("26.1.2", "neoforge")
		match("1.21.11", "neoforge")
		match("1.21.10", "neoforge")
		match("1.21.8", "neoforge")
		match("1.21.5", "neoforge")
		match("1.21.4", "neoforge")
		match("1.21.3", "neoforge")
		match("1.21.2", "neoforge")
		match("1.21.1", "neoforge")
		match("1.21.0", "neoforge")
		match("1.20.6", "neoforge")
		match("1.20.1", "forge")

		vcsVersion = "26.2-neoforge"
	}
}

private fun getBuildscript(loader: String, version: String): String {
	if (loader == "fabric") {
		return if (version.startsWith("1.")) {
			"build.fabric-o.gradle.kts"
		} else {
			"build.fabric-m.gradle.kts"
		}
	}
	return "build.$loader.gradle.kts"
}
