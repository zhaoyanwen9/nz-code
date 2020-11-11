module.exports = {
    // axios域代理，解决axios跨域问题
    // baseUrl: '/',
    devServer: {
        // host: "localhost",
        port: 8082,
        // https: false,
        // open: false,
        proxy: {
            '/proxy/task/api': {
                target: 'http://localhost:5050',
                changeOrigin: true, //开启代理
                ws: true, // 是否启用websockets
                pathRewrite: {
                    "^/proxy/task/api": "" // '/api'代替target
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
