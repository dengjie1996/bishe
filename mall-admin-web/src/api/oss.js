import request from '@/utils/request'

export function policy() {
  return request({
    url: 'mall-admin/minio/upload',
    method: 'get',
  })
}
