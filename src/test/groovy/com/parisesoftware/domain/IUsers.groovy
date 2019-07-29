package com.parisesoftware.domain

import com.parisesoftware.archetype.person.FirstName

/**
 * Sample Interface for us to Test our Domain Layer Supertype
 */
interface IUsers extends IObjectDomain {

    Map<FirstName, Integer> getFirstNames()

}
