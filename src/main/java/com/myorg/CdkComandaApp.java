package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;

import java.util.Arrays;

public class CdkComandaApp {
    public static void main(final String[] args) {
        App app = new App();

        // CREATING VPC
        VpcStack vpcStack = new VpcStack(app, "VpcComanda");

        //CREATING CLUSTER
        ClusterStack clusterStack = new ClusterStack(app, "ClusterComanda", vpcStack.getVpc());
        clusterStack.addDependency(vpcStack);

        //CREATING RDS (DATABASE)
        RdsStack rdsStack = new RdsStack(app, "RdsComanda", vpcStack.getVpc());
        rdsStack.addDependency(vpcStack);

        app.synth();
    }
}

