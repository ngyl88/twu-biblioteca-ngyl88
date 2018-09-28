package com.twu.biblioteca;

import java.util.ArrayList;

public abstract class AbstractResources {

    abstract ArrayList<? extends AbstractResource> getResources();

    public String getAvailableResourcesInDescriptiveString() {
        StringBuilder sb = new StringBuilder();
        for (AbstractResource resource : getResources()) {
            if (resource.isAvailable()) {
                sb.append(resource.getDetailsAsString());
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public boolean checkout(String resourceIdentifier, String userLibraryNumber) {
        for (AbstractResource resource : getResources()) {
            if (resource.getIdentifier().equals(resourceIdentifier) && resource.isAvailable()) {
                resource.checkout(userLibraryNumber);
                return true;
            }
        }
        return false;
    }

    public boolean returnResource(String resourceIdentifier) {
        for (AbstractResource resource : getResources()) {
            if (resource.getIdentifier().equals(resourceIdentifier) && !resource.isAvailable()) {
                resource.returned();
                return true;
            }
        }
        return false;
    }

}
