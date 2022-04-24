package com.sandbox.springboot.statement;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

//@Configuration
//@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<FSMStates, FSMEvents> {
    class ProcessModel<STATE, EVENT> {
        private EVENT event;

        private STATE initial;
        private STATE source;
        private STATE target;
        private Action<FSMStates, FSMEvents> action;
        private String type;

    }

    @Override
    public void configure(StateMachineStateConfigurer<FSMStates, FSMEvents> states)
            throws Exception {
        states
                .withStates()
                .initial(FSMStates.A)
                .states(EnumSet.allOf(FSMStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<FSMStates, FSMEvents> transitions)
            throws Exception {
        transitions
                .withExternal()
//                .source(FSMStates.A).target(FSMStates.B)
                .source(FSMStates.A).target(FSMStates.B)
                .event(FSMEvents.ToB).action(customerA2B())
//
                .and()
                .withExternal()
                .source(FSMStates.B).target(FSMStates.C)
                .event(FSMEvents.ToC).action(customerB2C())
//                .withFork()
//                .source(FSMStates.B).target(FSMStates.C).target(FSMStates.D)
//                .event(FSMEvents.ToB).action(customerA2B())


                .and()
                .withExternal()
                .source(FSMStates.C).target(FSMStates.D)
                .event(FSMEvents.ToD).action(customerC2D())

                .and()
                .withExternal()
                .source(FSMStates.D).target(FSMStates.A)
                .event(FSMEvents.ToA).action(customerD2A());
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<FSMStates, FSMEvents> config)
            throws Exception {
        config.withConfiguration()
                .machineId("stateMachine");
    }

    public Action<FSMStates, FSMEvents> customerA2B() {
        return context -> System.out.println("A->B");
    }

    public Action<FSMStates, FSMEvents> customerB2C() {
        return context -> System.out.println("B->C");
    }

    public Action<FSMStates, FSMEvents> customerC2D() {
        return context -> System.out.println("C->D");
    }

    public Action<FSMStates, FSMEvents> customerD2A() {
        return context -> System.out.println("D->A");
    }

}
