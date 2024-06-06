#include <iostream>
#include <vector>

using namespace std;

vector<long long> A;

int main() {
    int N, H, P; cin >> N >> H >> P; long long sum = 0, ans;
    for (int i = 0; i < N; i++) {
        long long power; cin >> power;
        A.push_back(power);
        sum += power;
    }
    sort(A.begin(), A.end());
    ans = sum * P;
    for (int i = 0; i < N; i++) {
        ans = min(ans, A[i] * H + (sum - (N - i) * A[i]) * P);
        sum -= A[i];
    }
    cout << ans << "\n";
    return 0;
}