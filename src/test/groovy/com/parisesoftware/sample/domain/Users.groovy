package com.parisesoftware.sample.domain

/**
 * Sample Class for us to Test our Domain Layer Supertype
 */
class Users extends ObjectDomain implements IUsers {

    Users(List<User> objectList) {
        super(objectList)
    }

    @Override
    Map<FirstName, Integer> getFirstNames() {

        List<Name> names = (records as List<User>)*.name
        Map<FirstName, Integer> firstNames = [:]

        for (Name curName : names) {
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
