package com.parisesoftware.sample.domain

/**
 * Layer Supertype for Object Domain Models
 */
abstract class ObjectDomain implements IObjectDomain {

    List<Object> records
    Class objectType

    ObjectDomain(List<Object> objectList) {
        this(objectList, objectList.getClass())
    }

    ObjectDomain(List<Object> objectList, Class type) {
        setRecords(objectList.clone() as List<Object>)
        setObjectType(type)
    }

    private void setRecords(List<Object> records) {
        this.records = records
    }

    private void setObjectType(Class objectType) {
        this.objectType = objectType
    }

}
