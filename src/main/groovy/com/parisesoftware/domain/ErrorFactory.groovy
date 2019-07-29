package com.parisesoftware.domain

class ErrorFactory {

    private List errorList = []

    private ErrorFactory() {}

    String error(String message, Object record) {
        return errorWithDomain(null, message, record)
    }

    private String errorWithDomain(ObjectDomain domain, String message, Object record) {
        DomainRecordError domainRecordError = new DomainRecordError(
                domain: domain,
                message: message,
                record: record
        )
        errorList.add(domainRecordError)
        return message
    }

    List getAll() {
        return errorList.clone() as List<DomainError>
    }

    void clearAll() {
        errorList.clear()
    }

}
