// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router' // Library imports.
import axios from 'axios'
import VueAxios from 'vue-axios'
import moment from 'vue-moment'

Vue.use(VueAxios,axios.create({ // Use plugins by calling the Vue.use() global method. 
  baseURL: 'http://localhost:8080/api', // You can optionally pass in some options.
  headers: {
    'Access-Control-Allow-Origin': 'http://localhost:8081'
  }
}))

Vue.use(moment)
Vue.config.productionTip = false // Enables vue dev tools in browser.

new Vue({ // Every Vue application starts by creating a new Vue instance with the Vue function.
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
