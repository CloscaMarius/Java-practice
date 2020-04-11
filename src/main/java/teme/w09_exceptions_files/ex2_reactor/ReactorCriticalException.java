package teme.w09_exceptions_files.ex2_reactor;

class ReactorCriticalException extends Exception {
    ReactorCriticalException() {

    }

    ReactorCriticalException(String msg) {
        super(msg);
    }
}
