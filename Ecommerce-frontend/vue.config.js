module.exports = {
    devServer: {
      port: 8081,
      disableHostCheck: true
    },
    configureWebpack: {
      // ...
    },
    // Set environment variables for the development server
    // using the process.env object
    chainWebpack: (config) => {
      config.plugin('define').tap((args) => {
        args[0]['process.env'] = {
          ...args[0]['process.env'],
          NODE_OPTIONS: JSON.stringify('--openssl-legacy-provider')
        };
        return args;
      });
    }
  };
  