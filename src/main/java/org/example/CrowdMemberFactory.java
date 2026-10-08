package org.example;

// Factory Method: callers ask for a type and never use "new" on the subclasses
public class CrowdMemberFactory {

    public static CrowdMember create(CrowdMemberType type, String name) {
        if (type == null) {
            throw new IllegalArgumentException("Crowd member type is required");
        }
        switch (type) {
            case ENTHUSIASTIC:
                return new EnthusiasticCrowdMember(name);
            case CALM:
                return new CalmCrowdMember(name);
            default:
                throw new IllegalArgumentException("Unknown crowd member type");
        }
    }
}
