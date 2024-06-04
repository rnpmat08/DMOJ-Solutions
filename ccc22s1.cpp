#include <iostream>

using namespace std;

int main() {
    int N, ans = 0; cin >> N;
    for (int i = 0; i <= N / 4; i++) if ((N - 4 * i) % 5 == 0) ans++;
    cout << ans;
}