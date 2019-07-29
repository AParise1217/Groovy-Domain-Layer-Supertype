package com.parisesoftware.domain

import com.parisesoftware.archetype.person.FirstName
import com.parisesoftware.archetype.person.PersonName
import com.parisesoftware.archetype.user.User

/**
 * Sample Class for us to Test our Domain Layer Supertype
 */
class Users extends ObjectDomain implements IUsers {

    Users(List<User> objectList) {
        super(objectList)
    }

    @Override
    Map<FirstName, Integer> getFirstNames() {

        List<PersonName> names = (records as List<User>)*.person.personName
        Map<FirstName, Integer> firstNames = [:]

        for (PersonName curName : names) {
            FirstName firstName = curName.firstName
            if (firstNames.keySet().contains(firstName)) {
                int count = firstNames.get(firstName)
                firstNames.replace(firstName, count + 1)
            } else {
                firstNames.put(firstName, 1)
            }
        }
        return firstNames
    }



}
