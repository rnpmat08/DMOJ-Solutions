#include <iostream>
#include <vector>

using namespace std;

int w[7];

int main() {
    int n; cin >> n;
    for (int i = 1; i <= n; i++) w[i] = 1;
    for (int i = 1, j; i <= n - 1; i++) { cin >> j; w[j] *= w[i] + 1; }
    cout << w[n];
    return 0;
}
