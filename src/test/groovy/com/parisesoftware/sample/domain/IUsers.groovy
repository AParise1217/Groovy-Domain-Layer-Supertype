package com.parisesoftware.sample.domain

/**
 * Sample Interface for us to Test our Domain Layer Supertype
 */
interface IUsers extends IObjectDomain {

    Map<FirstName, Integer> getFirstNames()

}
