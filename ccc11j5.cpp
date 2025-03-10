#include <iostream>
#include <vector>

using namespace std;

vector<int> g[7];

int dfs(int i) {
    if (g[i].empty()) return 1;
    int ans = 1;
    for (int u : g[i]) ans *= dfs(u) + 1;
    return ans;
}

int main() {
    int n; cin >> n;
    for (int i = 1, j; i <= n - 1; i++) { cin >> j; g[j].push_back(i); }
    cout << dfs(n);
    return 0;
}