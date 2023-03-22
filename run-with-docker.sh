docker run --rm \
	--user root \
	--privileged=true \
        --name jupyter-java-${PWD##*/} \
        --volume $PWD:/home/jovyan/work/${PWD##*/} \
	--volume /var/run/docker.sock:/var/run/docker.sock \
        --publish 8888:8888 \
        --env NB_UID=$UID \
        --env JUPYTER_ENABLE_LAB=yes \
        brunoe/jupyter-java:develop start-notebook.sh --notebook-dir=${PWD##*/}
