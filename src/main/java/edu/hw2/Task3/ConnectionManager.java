package edu.hw2.Task3;

public interface ConnectionManager {
    Connection getConnection();

    class DefaultConnectionManager implements ConnectionManager {
        private static final double FAILURE_PROBABILITY = 0.5;

        @Override
        public Connection getConnection() {
            double n = Math.random();
            if (n > FAILURE_PROBABILITY) {
                return new Connection.StableConnection();
            }
            return new Connection.FaultyConnection();
        }
    }

    class FaultyConnectionManager implements ConnectionManager {

        @Override
        public Connection getConnection() {
            return new Connection.FaultyConnection();
        }
    }
}
