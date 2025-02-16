/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy.client.event.subject;

import com.nhnacademy.client.event.observer.Observer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageSubject implements Subject {

    private final List<Observer> observers;

    public MessageSubject() {
        observers = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public void register(EventType eventType, Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(EventType eventType, Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(EventType eventType, String message) {
        for(Observer observer : observers){
            if(observer.validate(eventType)){
                observer.updateMessage(message);
            }
        }
    }
}
