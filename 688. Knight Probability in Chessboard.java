public double knightProbability(int N, int K, int r, int c) {
            double[][] pre = new double[N][N];
            pre[r][c] = 1D;
            for(int k = 1; k <= K; k++){
                double[][] dp = new double[N][N];
                for(int i = 0; i < N; i++){
                    for(int j = 0; j < N; j++){
                        dp[i][j] = ((i - 1 >= 0 && j - 2 >= 0) ? pre[i - 1][j - 2]: 0)
                            + ((i - 2 >= 0 && j - 1 >= 0) ? pre[i - 2][j - 1]: 0)
                            + ((i + 1 < N && j - 2 >= 0) ? pre[i + 1][j - 2]: 0)
                            + ((i + 2 < N && j - 1 >= 0) ? pre[i + 2][j - 1]: 0)
                            + ((i - 2 >= 0 && j + 1 < N) ? pre[i - 2][j + 1]: 0)
                            + ((i - 1 >= 0 && j + 2 < N) ? pre[i - 1][j + 2]: 0)
                            + ((i + 1 < N && j + 2 < N) ? pre[i + 1][j + 2]: 0)
                            + ((i + 2 < N && j + 1 < N) ? pre[i + 2][j + 1]: 0);
                    }
                }
                pre = dp;
            }
            double sum = 0;
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    sum += pre[i][j];
            return sum / Math.pow(8, K);
        }
    }