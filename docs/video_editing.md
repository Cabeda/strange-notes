# Video Editing

## Concatenate videos

```shell
ffmpeg -i input1.mp4 -i input2.mp4 -i input3.mp4 -i input4.mp4 -i input5.mp4 -filter_complex concat=n=5:v=1:a=1 output.mp4
```
