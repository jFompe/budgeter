import { createRouter, createWebHashHistory } from "vue-router";
import InstitutionSelector from "@/views/InstitutionSelector.vue";


export default createRouter({
    history: createWebHashHistory(),
    routes: [
        // {
        //     path: '/',
        //     alias: '/dashboard',
        //     name: 'dashboard',
        //     component: DashboardView,
        // },
        {
            path: '/',
            alias: '/institutions',
            name: 'institutions',
            component: InstitutionSelector,
        },
        // {
        //     path: '/lines',
        //     name: 'sparkline',
        //     component: () => import('../views/SparkView.vue')
        // },
        // {
        //     path: '/sankey',
        //     name: 'sankey',
        //     component: () => import('../views/SankeyView.vue')
        // },
        // {
        //     path: '/bars',
        //     name: 'bars',
        //     component: () => import('../views/BarsView.vue')
        // },
        // {
        //     path: '/filters',
        //     name: 'filters',
        //     component: () => import('../views/FiltersView.vue')
        // },
        // {
        //     path: '/transactions', 
        //     name: 'transactions',
        //     component: () => import('../views/TransactionsTable.vue')
        // }
        
    ]
})