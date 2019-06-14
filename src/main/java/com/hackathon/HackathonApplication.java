package com.hackathon;

import com.hackathon.db.EmployeeAccessor;
import com.hackathon.db.UserAccessor;
import com.hackathon.impl.EmployeeApiApiImpl;
import com.hackathon.impl.HelloWorldApiApiImpl;
import com.hackathon.impl.UserApiImpl;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HackathonApplication extends Application<HackathonConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HackathonApplication().run(args);
    }

    @Override
    public String getName() {
        return "Hackathon";
    }

    @Override
    public void initialize(final Bootstrap<HackathonConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HackathonConfiguration configuration,
                    final Environment environment) {
        try {
            // TODO: implement application
            environment.jersey().register(new HelloWorldApiApiImpl());
            environment.jersey().register(new EmployeeApiApiImpl(new EmployeeAccessor()));
            environment.jersey().register(new UserApiImpl(new UserAccessor()));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
