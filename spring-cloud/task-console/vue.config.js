module.exports = {
    // axios域代理，解决axios跨域问题
    // baseUrl: '/',
    lintOnSave: false,
    devServer: {
        // host: "localhost",
        port: 8080,
        // https: false,
        // open: false,
        proxy: {
            '/api': {
                // target: 'http://localhost:5050',
                target: 'http://localhost:9090',
                changeOrigin: true, //开启代理
                ws: true, // 是否启用websockets
                pathRewrite: {
                    "^/api": "" // '/api'代替target
                }
            },
            '/proxy-permission/api/': {
                target: 'http://localhost:xxxx/',
                changeOrigin: true
            },
            '/proxy-dashboard/adm/': {
                target: 'http://localhost:xxxx/',
                changeOrigin: true
            },
            '/httpsProxy-monitor/api/': {
                target: 'https://100.95.153.4',
                secure: false, // https协议才设置
                changeOrigin: true
            }
        }
    }
}
