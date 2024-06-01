#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N, ans = 0; cin >> N;
    vector<int> P(N);
    for (int i = 0; i < N; i++) cin >> P[i];
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j <= N; j++) {
            vector<int> V(P.begin() + i, P.begin() + j);
            double A = 0; int avg = 0;
            for (int k : V) A += k;
            A /= V.size(); avg = static_cast<int> (A);
            if (avg == A) {
                for (int k : V) {
                    if (k == avg) {
                        ans++;
                        break;
                    }
                }
            }
        }
    }
    cout << ans;
    return 0;
}
