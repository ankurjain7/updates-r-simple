package de.idos.updates;

import de.idos.updates.store.FilesystemInstallationStarter;
import de.idos.updates.store.FilesystemVersionStore;
import de.idos.updates.store.ZipInstallationStarter;

import java.io.File;

public class VersionStoreBuilder {

    private File versionStore;

    public static VersionStoreBuilder inUserHomeForApplication(String applicationName) {
        VersionStoreBuilder builder = new VersionStoreBuilder();
        File userHome = new File(System.getProperty("user.home"));
        File applicationHome = new File(userHome, "." + applicationName);
        builder.versionStore = new File(applicationHome, "versions");
        return builder;
    }

    public VersionStore create() {
        return new FilesystemVersionStore(versionStore, new ZipInstallationStarter(new FilesystemInstallationStarter()));
    }
}