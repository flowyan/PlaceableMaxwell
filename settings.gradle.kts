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

		// Add more versions/loaders here
		match("1.20.1", "forge")

		match("26.1", "neoforge")
		match("26.1.1", "neoforge")
		match("26.1.2", "neoforge")

		// Should be the latest release
		vcsVersion = "26.1.2-neoforge"
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
