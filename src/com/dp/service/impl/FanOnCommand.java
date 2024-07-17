package com.dp.service.impl;


import com.dp.entity.Fan;
import com.dp.service.Command;

public class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }
}
