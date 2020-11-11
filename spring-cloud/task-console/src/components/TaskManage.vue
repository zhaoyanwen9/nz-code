<template>
    <div>
        <el-row :gutter="10">
            <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1"><div class="grid-content bg-purple">qq</div></el-col>
            <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11"><div class="grid-content bg-purple-light">aa</div></el-col>
            <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11"><div class="grid-content bg-purple">dd</div></el-col>
            <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1"><div class="grid-content bg-purple-light">cc</div></el-col>
        </el-row>

        <el-row>
            <el-col :span="24">
                <el-table
                        :data="tableData"
                        style="width: 100%"
                        border>
                    <el-table-column label="id" prop="id"></el-table-column>
                    <el-table-column label=名称 prop="name" show-overflow-tooltip>
                        <template scope="scope">
                            <el-link :href="scope.row.name" target="_blank">{{scope.row.name}}</el-link>
                        </template>
                    </el-table-column>
                    <el-table-column label="类型" prop="type"></el-table-column>
                    <el-table-column label="环境组" prop="envGrp"></el-table-column>
                    <el-table-column label="状态" prop="status"></el-table-column>
                    <el-table-column label="进度" prop="progress" width="200">
                        <el-progress :percentage="100" status="success"></el-progress>
                    </el-table-column>
                    <el-table-column label="操作" align="right">
                        <template slot-scope="scope">
                            <el-tooltip class="item" effect="dark" content="编辑" placement="top">
                                <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">
                                    <i class="el-icon-edit"></i>
                                </el-button>
                            </el-tooltip>
                            <el-tooltip class="item" effect="dark" content="删除" placement="top">
                                <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">
                                    <i class="el-icon-delete"></i>
                                </el-button>
                            </el-tooltip>
                        </template>
                    </el-table-column>
                </el-table>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "TaskManage",
        data() {
            return {
                tableData: [],
            }
        },
        created() {
            this.getTableData();
        },
        methods: {
            handleEdit(index, row) {
                console.log(index, row);
            },
            handleDelete(index, row) {
                console.log(index, row);
            },
            getTableData() {
                this.axios.get('/proxy/task/api/gateway/zuul-task/feign-task/getByRp/', {
                    params: {
                        page: 1,
                        size: 15,
                        name: '',
                    }
                }).then(response => {
                        this.tableData = response.data.content;
                    }
                ).catch(function (error) {
                    console.log(error);
                });
            }
        },
    }
</script>

<style scoped>

</style>

<style>
    .el-col {
        border-radius: 4px;
    }
    .bg-purple-dark {
        background: #99a9bf;
    }
    .bg-purple {
        background: #d3dce6;
    }
    .bg-purple-light {
        background: #e5e9f2;
    }
    .grid-content {
        border-radius: 4px;
        min-height: 36px;
    }
</style>
