package org.example;

public class EnthusiasticCrowdMember extends CrowdMember {

    public EnthusiasticCrowdMember(String name) {
        super(name);
    }

    @Override
    public String clap() {
        return "CLAP CLAP CLAP!!!";
    }
}
