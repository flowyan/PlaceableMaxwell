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
		maven("https://jitpack.io") { name = "Jitpack" }
		maven("https://raw.githubusercontent.com/Fuzss/modresources/main/maven/") { name = "Fuzs Mod Resources" }
		maven("https://maven.terraformersmc.com/") { name = "Terraformers" }

		exclusiveContent {
			forRepository { maven("https://api.modrinth.com/maven") { name = "Modrinth" } }
			filter { includeGroup("maven.modrinth") }
		}
	}
	includeBuild("build-logic")
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
	id("dev.kikugie.stonecutter") version "0.8"
}

stonecutter {
	create(rootProject) {
		fun match(version: String, vararg loaders: String) =
			loaders.forEach { version("$version-$it", version).buildscript = "build.$it.gradle.kts" }

		// Add more versions/loaders here
		match("1.20.1", "forge")
		match("1.20.6", "neoforge")
		match("1.21.0", "neoforge")
		match("1.21.1", "neoforge")
		match("1.21.2", "neoforge")
		match("1.21.3", "neoforge")
		match("1.21.4", "neoforge")
		match("1.21.5", "neoforge")
		match("1.21.6", "neoforge")
		match("1.21.7", "neoforge")
		match("1.21.8", "neoforge")
		match("1.21.9", "neoforge")
		match("1.21.10", "neoforge")
		match("1.21.11", "neoforge")

		// Should be the latest release
		vcsVersion = "1.21.11-neoforge"
	}
}
