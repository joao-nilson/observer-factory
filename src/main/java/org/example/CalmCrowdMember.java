package org.example;

public class CalmCrowdMember extends CrowdMember {

    public CalmCrowdMember(String name) {
        super(name);
    }

    @Override
    public String clap() {
        return "clap clap";
    }
}
