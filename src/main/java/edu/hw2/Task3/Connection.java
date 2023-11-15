package edu.hw2.Task3;

public interface Connection extends AutoCloseable {
    void execute(String command);

    class StableConnection implements Connection {

        @Override
        public void execute(String command) {
        }

        public void close() {
        }
    }

    class FaultyConnection implements Connection {
        private static final double FAILURE_PROBABILITY = 0.5;

        @Override
        public void execute(String command) {
            double n = Math.random();
            if (n < FAILURE_PROBABILITY) {
                throw new ConnectionException(1, "faulty connection");
            }
        }

        @Override
        public void close() {
        }
    }
}
