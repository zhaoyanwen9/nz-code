<template>
    <div id="app">
        <el-container>
            <el-aside width="210px">
                <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
                    <el-radio-button :label="false">展开</el-radio-button>
                    <el-radio-button :label="true">收起</el-radio-button>
                </el-radio-group>
                <el-menu :default-active="activeIndex" class="el-menu-vertical-demo" @open="handleOpen"
                         @close="handleClose" :collapse="isCollapse"
                         background-color="#545c64"
                         text-color="#fff"
                         active-text-color="#ffd04b"
                         @select="handleSelect"
                         router>
                </el-menu>
            </el-aside>
            <el-main>
                <router-view/>
            </el-main>
        </el-container>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                isCollapse: false,
                activeIndex: "about",
                navMenuData: [
                    {index: "about", name: "电影"},
                    {index: "home", name: "小说"},
                    {
                        index: "2",
                        name: "我的工作台",
                        child: [{index: "2-1", name: "选项1"}, {index: "2-2", name: "选项2"}, {index: "2-3", name: "选项3"}]
                    }
                ]
            };
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            }
        },
        mounted() {
            console.log(this.activeIndex)
            console.log(this.$route.path)
            this.activeIndex = this.$route.path.substring(1, this.$route.path.length);
        }
    }
</script>

<style lang="scss">
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }

    #nav {
        padding: 30px;

        a {
            font-weight: bold;
            color: #2c3e50;

            &.router-link-exact-active {
                color: #42b983;
            }
        }
    }

    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 200px;
        min-height: 650px;
    }
</style>
